protoc -I=simple/ --python_out=simple/ simple/simple.proto
protoc -I=enumeration/ --python_out=enumeration/ enumeration/enumeration.proto
protoc -I=complex/ --python_out=complex/ complex/complex.proto