# compiling source code
javac  -d ./bin --enable-preview --release 19 $(find  ./src -name '*.java') 

# exporting generic to a jar file

cd ./bin

jar cvf ../everest-spring.jar *
