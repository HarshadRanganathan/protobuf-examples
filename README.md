# protobuf-examples

## Pre-requisites

[protoc](https://github.com/protocolbuffers/protobuf/releases/latest)

## Code Generation

Run below commands to generate protobuf code in various languages based on the proto files defined inside messages directory.

Note: source/python & source/java directories should be created.

```bash
$ protoc --python_out=source/python  messages/*.proto
$ protoc --java_out=source/java  messages/*.proto
```

## References

- Protocol Buffers Udemy course by Stephane Maarek