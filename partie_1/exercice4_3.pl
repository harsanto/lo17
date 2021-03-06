#!/usr/bin/perl

# UV : LO17 - partie 1
# Préparation du Corpus
# Auteurs : Dany Ferreira - Antoine Hars
# Fichier : exercice4_3.pl

$fichier1 = $ARGV[0];
$fichier2 = $ARGV[1];
$compt = 0;

open(FICHIN, "LCI_EXTRACT_3/$fichier1") or die "Cannot open fichier: $!";
chdir("LCI_EXTRACT_4/");
open(FICHOUT, ">>$fichier2") or die "Cannot open fichier: $!";

# Traitement sur le FOCUS.
while($a = <FICHIN>) {

	if($a =~/^<FOCUS>/) {
	
		print FICHOUT "\t\t<FOCUS>\n";

		if ($a =~/\<a[^>]*href=(.*?)\sclass="S48">/) {
			print FICHOUT "\t\t\t<urlArticle>$1</urlArticle>\n";
		} else {
			print FICHOUT "\t\t\t<urlArticle>PAS D'INFORMATIONS</urlArticle>\n";
		}

		if ($a =~/">(.*?)<\/a>/) {
			print FICHOUT "\t\t\t<titreArticle>$1</titreArticle>\n";
		} else {
			print FICHOUT "\t\t\t<titreArticle>PAS D'INFORMATIONS</titreArticle>\n";
		}

		# On suppose que la date de l'article est la date de la page
		$fichier1 =~ /(\d\d\d\d)-(\d\d)-(\d\d)/;
		print FICHOUT "\t\t\t<dateArticle>$3/$2/$1</dateArticle>\n";

		if ($a =~/<img\ssrc="(.*?)"/) {
			print FICHOUT "\t\t\t<urlImage>$1</urlImage>\n";
		} else {
			print FICHOUT "\t\t\t<urlImage>PAS D'INFORMATIONS</urlImage>\n";
		}

		if ($a =~/class="S48">(.*?)<\/a>/) {
			print FICHOUT "\t\t\t<resumeArticle>$1</resumeArticle>\n";
		} else {
			print FICHOUT "\t\t\t<resumeArticle>PAS D'INFORMATIONS</resumeArticle>\n";
		}

		if ($a =~/<a href="mailto:(.*?)"/) {
			print FICHOUT "\t\t\t<mailto>$1</mailto>\n";
		}
		# Possibilité de faire apparaître qu'il n'y a pas de mailto.
		# else {
		#	print FICHOUT "\t\t\t<mailto>PAS D'INFORMATIONS</mailto>\n";
		# }

		if ($a =~/class="S14">(.*?)<\/a>/) {
			print FICHOUT "\t\t\t<auteur>$1</auteur>\n";
		}
		# Possibilité de faire apparaître qu'il n'y a pas d'auteur.
		# else {
		#	print FICHOUT "\t\t\t<auteur>PAS D'INFORMATIONS</auteur>\n";
		# }

		print FICHOUT "\t\t</FOCUS>\n";

		$compt++;
	}
}

print $compt;

close(FICHOUT);
close(FICHIN);

