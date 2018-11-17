import message_pb2

class MessageHeader(object):
    #--------------Constructor--------------
    def __init__(self,magic,version,byteOrder,messageType,messageSize):
        self.__messageHeader = message_pb2.MessageHeader()
        self.__messageHeader.magic = magic
        self.__messageHeader.version = version
        self.__messageHeader.byteOrder = byteOrder
        self.__messageHeader.messageType = messageType
        self.__messageHeader.messageSize = messageSize
    
    #---------------------------------------

    #----------Getters and Setters----------
    def getMagic(self):
        return self.__messageHeader.magic

    def getVersion(self):
        return self.__messageHeader.version

    def getByteOrder(self):
        return self.__messageHeader.byteOrder

    def getMessageType(self):
        return self.__messageHeader.messageType

    def getMessageSize(self):
        return self.__messageHeader.messageSize

    def setMagic(self,magic):
        self.__messageHeader.magic = magic

    def setVersion(self,version):
        self.__messageHeader.version = version

    def setByteOrder(self,byteOrder):
        self.__messageHeader.byteOrder = byteOrder

    def setMessageType(self,messageType):
        self.__messageHeader.messageType = messageType

    def setMessageSize(self,messageSize):
        self.__messageHeader.messageSize = messageSize

    #---------------------------------------