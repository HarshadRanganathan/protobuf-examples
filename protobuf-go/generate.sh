protoc -I src/ --go_out=src/ src/simple/simple.proto
protoc -I src/ --go_out=src/ src/enumeration/enumeration.proto
protoc -I src/ --go_out=src/ src/complex/complex.proto