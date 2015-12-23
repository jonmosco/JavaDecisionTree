#!/usr/bin/perl -W
# $Id$

use strict;
use warnings;
use LWP::Simple;

sub vsleep {
	select undef, undef, undef, $_[0];
}

my $domain = 'http://www.globalcarsbrands.com';
my $data = get("$domain/british-car-brands/")
    or die "get: $!\n";
$data =~ s!^.*<h3>Car Brands List</h3>!!ms or die "unexpected format";
$data =~ s!^(.*?)</div>.*!$1!ms or die "unexpected format";

# <li id="menu-item-436" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-436">
# <a href="/korean-car-brands/">Korean Cars</a></li>
my %countries = $data =~ m!<a href="(.*?)">(.*?) Cars</a>!gms;

while (my ($url, $country) = each %countries) {
	my $fodo = $country eq "American" ? "Domestic" : "Foreign";

	$url =~ s!^https?://www.globalcarsbrands.com!!;
	warn "GET $domain$url\n";
	$data = get("$domain/$url") or die "get $url: $!\n";

	my @makes = $data =~ m!<h([45])>(.*?)</h\1>!gms;
	for (my $i = 0; $i < @makes; $i++) {
		next unless $i % 2;
		my $make = $makes[$i];
		$make =~ s!<[^>]+>!!g;
		$make =~ s!\n!!gms;
		$make =~ s! Cars Ltd!!;
		print "$fodo:$country:$make\n";
	}

	vsleep .5;
}
