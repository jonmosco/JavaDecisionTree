#!/usr/bin/perl -W
# $Id$

use LWP::UserAgent;
use strict;
use warnings;

sub vsleep {
	select undef, undef, undef, $_[0];
}

sub uniq {
	my @out;
	my $last = "";
	for (@_) {
		push @out, $_ unless $_ eq $last;
	}
	return @out;
}

sub characterize_model {
	my ($ra, $attr) = @_;

	local $_ = $attr;
	$attr = undef;

	if (/^coup/i) {			$attr = "Coupe"; }
	elsif (/sports? utility/i) {	$attr = "SUV"; }
	elsif (/station wagon/i) {	$attr = "Station Wagon"; }
	elsif (/hatchback/i) {		$attr = "Hatchback"; }
	elsif (/subcompact/i) {		$attr = "Subcompact"; }
	elsif (/compact/i) {		$attr = "Compact"; }
	elsif (/sedan/i) {		$attr = "Sedan"; }
	elsif (/luxury/i) {		$attr = "Luxury"; }
	elsif (/mid[- ]?size/i) {	$attr = "Mid-size"; }
	elsif (/full[- ]?size/i) {	$attr = "Full-size"; }
	elsif (/sport/i) {		$attr = "Sports"; }
	elsif (/electric/i) {		$attr = "Electric"; }
	elsif (/hybrid/i) {		$attr = "Hybrid"; }
	elsif (/family/i) {		$attr = "Family"; }
	elsif (/mini/i) {		$attr = "Mini"; }
	elsif (/micro/i) {		$attr = "Micro"; }
	elsif (/roadster/i) {		$attr = "Roadster"; }
	elsif (/crossover suv/i) {	$attr = "SUV"; }
	elsif (/convertible/i) {	$attr = "Convertible"; }
	elsif (/Economy/i) {		$attr = "Economy"; }
	elsif (/off[- ]?road/i) {	$attr = "Off-road"; }
	elsif (/^suv/i) {		$attr = "SUV"; }

	elsif (/truck/i) {		$attr = "Truck"; }
	elsif (/minivan/i) {		$attr = "Minivan"; }
	elsif (/^van/i) {		$attr = "Van"; }

	# ignore
	elsif (/city/i) { }
	elsif (/2\+2/i) { }
	elsif (/grand tour/i) { }
	elsif (/intermediate/i) { }

	# we should actually prune these
	elsif (/supercar/i) { }
	elsif (/limousine/i) { }
	elsif (/concept/i) { }
	elsif (/^pony/i) { }
	elsif (/^kei\b/i) { }
	elsif (/<a/i) { }
	else {
		warn "unrecognized attribute: $_";
	}

	push @$ra, $attr if $attr;
}

my $ua = LWP::UserAgent->new;
$ua->agent('');
my $domain = 'http://www.ranker.com';
my $index_url = "$domain/fact-lists/automobile-models/make";
my $res = $ua->get($index_url) or die "get $index_url: $!\n";
my $data = $res->content;

# Example:
# <li> <a role="link" href="/list/full-list-of-gmc-models/reference">Full List of GMC Models</a> </li>
my %makes = $data =~ m[href="(/list/full-list-of-(?:.*?)-models/reference)">Full List of (.*?) Models]g;
while (my ($models_url, $make_name) = each %makes) {
	my $i = 1;
	my @models;
	my $referer = $index_url;
	do {
		my $url = "$domain$models_url";
		$url .= "?page=$i" if $i > 1;

		my $req = HTTP::Request->new(GET => $url);
		$req->header(referer => $referer);
		$referer = $url;

		$res = $ua->request($req) or next;
		$data = $res->content;
		# <span class="oNode" itemprop="name">Honda Legend</span>
		@models = split /<span class="oNode" itemprop="name">/, $data;
		shift @models;
		foreach my $model (@models) {
			my ($model_name) = $model =~ m[^(.*?)</span>]
			    or die "unexpected format";
			next if $model_name =~ /\bversion\b/;
			$model =~ m[<li><strong>Class:</strong>\s*(.*?)\s*</li>]ms
			    or next;

			my $attrs = $1;
			my @attrs = split /\s*,\s*/, $attrs;
			my @r_attrs; # recognized attributes
			foreach (@attrs) {
				characterize_model(\@r_attrs, $_);
			}
			print join(':', $make_name, $model_name,
			    uniq sort @r_attrs), "\n" if @r_attrs;
		}

		$i++;

		vsleep .5;

	} while (@models);

	vsleep 2;
}
