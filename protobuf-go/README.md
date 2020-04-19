## Install Dependendencies

To install module dependencies, run any of the below commands:

```bash
go mod tidy

go mod build
```

## Generate ProtoBuf Files

To generate protobuf files, run `generate.sh` script.

Once you have the dependencies and protobuf files generated, you can run `main.go` to see the output for various examples such as reading/writing to file, marshall/unmarshall to json, enumerations, complex types etc.