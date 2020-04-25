import complex.complex_pb2 as complex_pb2

complex_message = complex_pb2.ComplexMessage()

complex_message.one_dummy.id = 1
complex_message.one_dummy.name = "Dummy Message"

second_dummy_message = complex_message.multiple_dummy.add()
second_dummy_message.id = 2
second_dummy_message.name = "Second Dummy Message"

complex_message.multiple_dummy.add(id=3, name="Third Dummy Message")

fourth_dummy_message = complex_pb2.DummyMessage()
fourth_dummy_message.id = 4
fourth_dummy_message.name = "Fourth Dummy Message"

# copies over fourth_dummy_message to the list
complex_message.multiple_dummy.extend([fourth_dummy_message])

print(complex_message)