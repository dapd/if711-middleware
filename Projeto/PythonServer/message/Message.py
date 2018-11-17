import message_pb2

class Message(object):
    #--------------Constructor--------------
    def __init__(self,header,body):
        self.__message = message_pb2.Message()
        self.__message.header = header
        self.__message.body = body
    
    #---------------------------------------

    #----------Getters and Setters----------
    def getHeader(self):
        return self.__message.header

    def getBody(self):
        return self.__message.body

    def setHeader(self,header):
        self.__message.header = header

    def setBody(self,body):
        self.__message.body = body

    #---------------------------------------