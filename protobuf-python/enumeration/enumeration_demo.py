import enumeration.enumeration_pb2 as enumeration_pb2

enum_message = enumeration_pb2.EnumMessage()
enum_message.id = 12
enum_message.day_of_the_week = enumeration_pb2.THURSDAY

print(enum_message)

print(enum_message.day_of_the_week == enumeration_pb2.THURSDAY)