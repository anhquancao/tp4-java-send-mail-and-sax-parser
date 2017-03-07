# tp4-java-send-mail-and-sax-parser
##Institut Galil ́ee Master 1
##PDJ
##T.P. 4
##Mail, JNDI, SAX
L’objectif de ce TP en deux parties est de mettre en place un logiciel ayant l’objectif suivant :
— un client se connecte `a un serveur et donne un nom de r ́epertoire et une adresse mail
— le serveur envoie par mail le contenu du r ́epertoire
Plus techniquement, l’objectif est de vous faire pratiquer les modules suivants :
— JavaMail : pour l’envoi par mail
— JNDI : pour la lecture du r ́epertoire
— XML (SAX) : pour le protocole d’envoi-r ́eception
###1 JavaMail et JNDI
Dans ce premier cas, on consid`erera que le serveur est accessible par une socket (mode client-serveur). Le client connect ́e envoie s ́equentiellement
— le nom de la requˆete (seulement “LIST”),
— le nom de r ́epertoire,
— l’adresse mail
Le programme pourra ˆetre fait sous Eclipse, Netbeans ou par fichier direct.
De pr ́ef ́erence, on lancera le serveur dans une console, le client dans une autre console. Les classes `a  ́ecrire sont les suivantes :
— Client.java : Se connecte au serveur, envoie les informations dans l’ordre.
—ServerMaitre.java : Cr ́ee un thread avec une instance de ServerEsclave pour traiter les donn ́ees re ̧cues.
— ServerEsclave.java : Cr ́ee une instance de ReqList en demandant d’ex ́ecuter la requˆete si la commande est “LIST”.
— ReqList.java : Cr ́ee une instance de Repertoire pour r ́ecup ́erer l’ ́enum ́eration (NamingEnumeration) du contenu du r ́epertoire pass ́e en argument. Puis cr ́ee une instance de SendMail pour envoyer un mail avec le contenu de l’ ́enum ́eration transform ́e en chaˆıne de caract`eres.
— Repertoire.java : Utilise le provider de Sun pour les syst`emes de gestion de fichier pour envoyer l’ ́enum ́eration du contenu d’un r ́epertoire.
— SendMail.java : envoi de mail Les  ́el ́ements suivants sont n ́ecessaires :
— fscontext.jar et providerutil.jar pour JNDI
— activation.jar et mail.jar pour le JavaMail
Ces librairies peuvent ˆetre copi ́ees `a partir de mon site web (M1 PDJ).
La compilation se fait par la commande suivante :
javac -classpath mail.jar *java
Le lancement du serveur s’effectue par (le param`etre 11000 peut ˆetre chang ́e !) :
java -classpath .:mail.jar:fscontext.jar:providerutil.jar ServerMaitre 11000 Le lancement du serveur s’effectue par (les param`etres peuvent ˆetre chang ́es !) :
java Client localhost 11000 LIST . cf@lipn.univ-paris13.fr


###2 XML
Faire cet exercice aussi en mode console. La structure XML requise est la suivante :
<Request>
<ReqName>nom de la requ^ete (seulement "LIST")</ReqName> <Dir>nom de r ́epertoire</Dir>
<MailAddress>adresse mail</MailAddress>
</Request>
On reprend la structure des classes pr ́ec ́edentes avec les modifications suivantes : — Client.java : Se connecte au serveur, envoie les informations en utilisant
un envoi au format XML (on construit juste une chaˆıne de caract`eres). — ServerEsclave.java : Cr ́ee une instance de ReqList. Analyse le flux d’entr ́ee en cr ́eant une instance de SAXReqReader qui modifiera l’instance
de ReqList. Ex ́ecute la requˆete si la commande est “LIST”.
— SAXReqReader.java : Analyse le flux d’entr ́ee en utilisant comme ges-
tionnaire de contenu une instance de SAXReqReaderProcess.
— SAXReqReaderProcess.java : Analyse le flux d’entr ́ee selon les mots
clefs.
Les commandes de compilation et d’ex ́ecution sont identiques au cas pr ́ec ́edent.
