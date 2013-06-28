= README MOLGENIS docs module =

We use asciidoc + bootstrap plugin.

== Get ascii doc ==

1. download and install asciidoc

* download tarbal and unzip from http://sourceforge.net/projects/asciidoc/
* configure make make install

Then you can test it via command

	asciidoc

2. download and install bootstrap plugin

* download from http://laurent-laville.org/asciidoc/bootstrap/index.html
* install via command 

	asciidoc --backend install bootstrap-<version>.zip

Now you can build the documenten
	
	molgenis/doc/buildDoc.sh
