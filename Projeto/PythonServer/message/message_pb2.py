# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: message.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='message.proto',
  package='message',
  syntax='proto2',
  serialized_options=None,
  serialized_pb=_b('\n\rmessage.proto\x12\x07message\",\n\x0fOperationReturn\x12\x0b\n\x03msg\x18\x01 \x02(\t\x12\x0c\n\x04\x63ode\x18\x02 \x02(\x05\"M\n\x0bReplyHeader\x12\x16\n\x0eserviceContext\x18\x01 \x02(\t\x12\x11\n\trequestId\x18\x02 \x02(\x05\x12\x13\n\x0breplyStatus\x18\x03 \x02(\x05\"7\n\tReplyBody\x12*\n\x08opReturn\x18\x01 \x02(\x0b\x32\x18.message.OperationReturn\"s\n\rRequestHeader\x12\x0f\n\x07\x63ontext\x18\x01 \x02(\t\x12\x11\n\trequestId\x18\x02 \x02(\x05\x12\x18\n\x10responseExpected\x18\x03 \x02(\x08\x12\x11\n\tobjectKey\x18\x04 \x02(\x05\x12\x11\n\toperation\x18\x05 \x02(\t\"!\n\x0bRequestBody\x12\x12\n\nparameters\x18\x01 \x03(\t\"l\n\rMessageHeader\x12\r\n\x05magic\x18\x01 \x02(\t\x12\x0f\n\x07version\x18\x02 \x02(\x05\x12\x11\n\tbyteOrder\x18\x03 \x02(\x08\x12\x13\n\x0bmessageType\x18\x04 \x02(\x05\x12\x13\n\x0bmessageSize\x18\x05 \x02(\x03\"\xb9\x01\n\x0bMessageBody\x12-\n\rrequestHeader\x18\x01 \x02(\x0b\x32\x16.message.RequestHeader\x12)\n\x0brequestBody\x18\x02 \x02(\x0b\x32\x14.message.RequestBody\x12)\n\x0breplyHeader\x18\x03 \x02(\x0b\x32\x14.message.ReplyHeader\x12%\n\treplyBody\x18\x04 \x02(\x0b\x32\x12.message.ReplyBody\"U\n\x07Message\x12&\n\x06header\x18\x01 \x02(\x0b\x32\x16.message.MessageHeader\x12\"\n\x04\x62ody\x18\x02 \x02(\x0b\x32\x14.message.MessageBody')
)




_OPERATIONRETURN = _descriptor.Descriptor(
  name='OperationReturn',
  full_name='message.OperationReturn',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='msg', full_name='message.OperationReturn.msg', index=0,
      number=1, type=9, cpp_type=9, label=2,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='code', full_name='message.OperationReturn.code', index=1,
      number=2, type=5, cpp_type=1, label=2,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=26,
  serialized_end=70,
)


_REPLYHEADER = _descriptor.Descriptor(
  name='ReplyHeader',
  full_name='message.ReplyHeader',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='serviceContext', full_name='message.ReplyHeader.serviceContext', index=0,
      number=1, type=9, cpp_type=9, label=2,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='requestId', full_name='message.ReplyHeader.requestId', index=1,
      number=2, type=5, cpp_type=1, label=2,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='replyStatus', full_name='message.ReplyHeader.replyStatus', index=2,
      number=3, type=5, cpp_type=1, label=2,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=72,
  serialized_end=149,
)


_REPLYBODY = _descriptor.Descriptor(
  name='ReplyBody',
  full_name='message.ReplyBody',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='opReturn', full_name='message.ReplyBody.opReturn', index=0,
      number=1, type=11, cpp_type=10, label=2,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=151,
  serialized_end=206,
)


_REQUESTHEADER = _descriptor.Descriptor(
  name='RequestHeader',
  full_name='message.RequestHeader',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='context', full_name='message.RequestHeader.context', index=0,
      number=1, type=9, cpp_type=9, label=2,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='requestId', full_name='message.RequestHeader.requestId', index=1,
      number=2, type=5, cpp_type=1, label=2,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='responseExpected', full_name='message.RequestHeader.responseExpected', index=2,
      number=3, type=8, cpp_type=7, label=2,
      has_default_value=False, default_value=False,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='objectKey', full_name='message.RequestHeader.objectKey', index=3,
      number=4, type=5, cpp_type=1, label=2,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='operation', full_name='message.RequestHeader.operation', index=4,
      number=5, type=9, cpp_type=9, label=2,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=208,
  serialized_end=323,
)


_REQUESTBODY = _descriptor.Descriptor(
  name='RequestBody',
  full_name='message.RequestBody',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='parameters', full_name='message.RequestBody.parameters', index=0,
      number=1, type=9, cpp_type=9, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=325,
  serialized_end=358,
)


_MESSAGEHEADER = _descriptor.Descriptor(
  name='MessageHeader',
  full_name='message.MessageHeader',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='magic', full_name='message.MessageHeader.magic', index=0,
      number=1, type=9, cpp_type=9, label=2,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='version', full_name='message.MessageHeader.version', index=1,
      number=2, type=5, cpp_type=1, label=2,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='byteOrder', full_name='message.MessageHeader.byteOrder', index=2,
      number=3, type=8, cpp_type=7, label=2,
      has_default_value=False, default_value=False,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='messageType', full_name='message.MessageHeader.messageType', index=3,
      number=4, type=5, cpp_type=1, label=2,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='messageSize', full_name='message.MessageHeader.messageSize', index=4,
      number=5, type=3, cpp_type=2, label=2,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=360,
  serialized_end=468,
)


_MESSAGEBODY = _descriptor.Descriptor(
  name='MessageBody',
  full_name='message.MessageBody',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='requestHeader', full_name='message.MessageBody.requestHeader', index=0,
      number=1, type=11, cpp_type=10, label=2,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='requestBody', full_name='message.MessageBody.requestBody', index=1,
      number=2, type=11, cpp_type=10, label=2,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='replyHeader', full_name='message.MessageBody.replyHeader', index=2,
      number=3, type=11, cpp_type=10, label=2,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='replyBody', full_name='message.MessageBody.replyBody', index=3,
      number=4, type=11, cpp_type=10, label=2,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=471,
  serialized_end=656,
)


_MESSAGE = _descriptor.Descriptor(
  name='Message',
  full_name='message.Message',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='header', full_name='message.Message.header', index=0,
      number=1, type=11, cpp_type=10, label=2,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='body', full_name='message.Message.body', index=1,
      number=2, type=11, cpp_type=10, label=2,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto2',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=658,
  serialized_end=743,
)

_REPLYBODY.fields_by_name['opReturn'].message_type = _OPERATIONRETURN
_MESSAGEBODY.fields_by_name['requestHeader'].message_type = _REQUESTHEADER
_MESSAGEBODY.fields_by_name['requestBody'].message_type = _REQUESTBODY
_MESSAGEBODY.fields_by_name['replyHeader'].message_type = _REPLYHEADER
_MESSAGEBODY.fields_by_name['replyBody'].message_type = _REPLYBODY
_MESSAGE.fields_by_name['header'].message_type = _MESSAGEHEADER
_MESSAGE.fields_by_name['body'].message_type = _MESSAGEBODY
DESCRIPTOR.message_types_by_name['OperationReturn'] = _OPERATIONRETURN
DESCRIPTOR.message_types_by_name['ReplyHeader'] = _REPLYHEADER
DESCRIPTOR.message_types_by_name['ReplyBody'] = _REPLYBODY
DESCRIPTOR.message_types_by_name['RequestHeader'] = _REQUESTHEADER
DESCRIPTOR.message_types_by_name['RequestBody'] = _REQUESTBODY
DESCRIPTOR.message_types_by_name['MessageHeader'] = _MESSAGEHEADER
DESCRIPTOR.message_types_by_name['MessageBody'] = _MESSAGEBODY
DESCRIPTOR.message_types_by_name['Message'] = _MESSAGE
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

OperationReturn = _reflection.GeneratedProtocolMessageType('OperationReturn', (_message.Message,), dict(
  DESCRIPTOR = _OPERATIONRETURN,
  __module__ = 'message_pb2'
  # @@protoc_insertion_point(class_scope:message.OperationReturn)
  ))
_sym_db.RegisterMessage(OperationReturn)

ReplyHeader = _reflection.GeneratedProtocolMessageType('ReplyHeader', (_message.Message,), dict(
  DESCRIPTOR = _REPLYHEADER,
  __module__ = 'message_pb2'
  # @@protoc_insertion_point(class_scope:message.ReplyHeader)
  ))
_sym_db.RegisterMessage(ReplyHeader)

ReplyBody = _reflection.GeneratedProtocolMessageType('ReplyBody', (_message.Message,), dict(
  DESCRIPTOR = _REPLYBODY,
  __module__ = 'message_pb2'
  # @@protoc_insertion_point(class_scope:message.ReplyBody)
  ))
_sym_db.RegisterMessage(ReplyBody)

RequestHeader = _reflection.GeneratedProtocolMessageType('RequestHeader', (_message.Message,), dict(
  DESCRIPTOR = _REQUESTHEADER,
  __module__ = 'message_pb2'
  # @@protoc_insertion_point(class_scope:message.RequestHeader)
  ))
_sym_db.RegisterMessage(RequestHeader)

RequestBody = _reflection.GeneratedProtocolMessageType('RequestBody', (_message.Message,), dict(
  DESCRIPTOR = _REQUESTBODY,
  __module__ = 'message_pb2'
  # @@protoc_insertion_point(class_scope:message.RequestBody)
  ))
_sym_db.RegisterMessage(RequestBody)

MessageHeader = _reflection.GeneratedProtocolMessageType('MessageHeader', (_message.Message,), dict(
  DESCRIPTOR = _MESSAGEHEADER,
  __module__ = 'message_pb2'
  # @@protoc_insertion_point(class_scope:message.MessageHeader)
  ))
_sym_db.RegisterMessage(MessageHeader)

MessageBody = _reflection.GeneratedProtocolMessageType('MessageBody', (_message.Message,), dict(
  DESCRIPTOR = _MESSAGEBODY,
  __module__ = 'message_pb2'
  # @@protoc_insertion_point(class_scope:message.MessageBody)
  ))
_sym_db.RegisterMessage(MessageBody)

Message = _reflection.GeneratedProtocolMessageType('Message', (_message.Message,), dict(
  DESCRIPTOR = _MESSAGE,
  __module__ = 'message_pb2'
  # @@protoc_insertion_point(class_scope:message.Message)
  ))
_sym_db.RegisterMessage(Message)


# @@protoc_insertion_point(module_scope)
