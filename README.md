# protobuf-examples


## Code Generation

Run below commands to generate protobuf code in various languages based on the proto files defined inside messages directory.

```bash
$ protoc --python_out=source/python  messages/*.proto
$ protoc --java_out=source/java  messages/*.proto
```