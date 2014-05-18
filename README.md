TheCampusOracle
===============

Oracle version of thecampus repository by mairouche

Corrected the Hibernate Annotation problem
===============

Removed *hibernate-commons-annotations* from pom.xml

Installed Oracle 11g Express drivers
===============

Downloaded here : http://www.oracle.com/technetwork/database/enterprise-edition/jdbc-112010-090769.html

Ran this command to install the driver to your local repository :

	mvn install:install-file -Dfile=Path/to/your/ojdbc.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar
	
Added the dependency in pom.xml :

	<!-- ORACLE database driver -->
	<dependency>
		<groupId>com.oracle</groupId>
		<artifactId>ojdbc6</artifactId>
		<version>11.2.0</version>
	</dependency>