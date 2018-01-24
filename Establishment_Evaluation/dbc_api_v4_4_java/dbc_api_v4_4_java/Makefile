JAVAC = javac
JAR = jar
JAVADOC = javadoc

NAME = DeathByCaptcha

OPT_SRC = org/*/*.java
LIB_SRC = com/$(NAME)/*.java
EXAMPLES_SRC = Example*.java


all: clean lib jar doc examples package


clean:
	find . -type f -name \*.class -delete
	-rm doc/com/DeathByCaptcha/*.html
	-rm dbc_api_java.zip

.PHONY: lib
lib:
	$(JAVAC) $(OPT_SRC) $(LIB_SRC)

.PHONY: jar
jar: lib
	$(JAR) cf jar/org.base64.jar org/base64/*.class
	$(JAR) cf jar/org.json.jar org/json/*.class
	$(JAR) cf jar/com.DeathByCaptcha.jar com/DeathByCaptcha/*.class

.PHONY: doc
doc:
	$(JAVADOC) -public -d doc $(LIB_SRC)

examples:
	$(JAVAC) $(EXAMPLES_SRC)

package:
	zip -9rX dbc_api_java.zip $(OPT_SRC) $(LIB_SRC) $(EXAMPLES_SRC) jar/*.jar Makefile doc readme.html -x \*/.svn/\*
