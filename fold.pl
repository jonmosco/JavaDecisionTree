#!/usr/bin/perl -W
# $Id$

use strict;
use warnings;

my %makes;

open BR, "<", "brands-data" or die "open brands: $!\n";
while (<BR>) {
	chomp;
	# Foreign:French:Peugeot
	my ($fodo, $country, $make) = split /:/;
	$makes{$make} = {
		fodo => $fodo,
		country => $country,
	};
}
close BR;

my $def = {
	fodo => "Foreign",
	country => "Unknown",
};

open C, "<", "car-data" or die "open cars: $!\n";
while (<C>) {
	# Toyota:RAV4:Compact:SUV
	my @f = split /:/;
	my $make = $f[0];
	$make = 'General Motors' if $make eq "General";
	$make = 'Volkswagen' if $make eq "Volkswagen Passenger";
	$make = 'General Motors' if $make eq "Volkswagen Passenger";

	my $m = exists $makes{$make} ? $makes{$make} : $def;
	$f[0] = $make;
	print join ':', $m->{fodo},$m->{country}, @f;
}
close C;
