build:
	javac $(shell find -name "*.java") -d "./bin" 

run:
	java -Xbootclasspath/a:./bin ap/gui/Main

exec:
	make -s build && make -s run
