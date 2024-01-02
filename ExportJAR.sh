# compiling source code
javac  -d ./bin --enable-preview --release 17 $(find  ./src -name '*.java') 

# exporting generic to a jar file

cd ./bin

jar cvf ../generic.jar *
