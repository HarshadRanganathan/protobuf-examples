import simple.simple_pb2 as simple_pb2

simple_message = simple_pb2.SimpleMessage()
simple_message.id = 123
simple_message.is_simple = True
simple_message.name = "Simple Message"
sample_list = simple_message.sample_list
sample_list.append(3)
sample_list.append(4)

# default values won't be printed
print(simple_message)

with open("simple.bin", "wb") as f:
    bytes_as_string = simple_message.SerializeToString()
    f.write(bytes_as_string)


with open("simple.bin", "rb") as f:
    simple_message_read = simple_pb2.SimpleMessage().FromString(f.read())
    print(simple_message_read)