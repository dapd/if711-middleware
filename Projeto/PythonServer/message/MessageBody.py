import message_pb2

class MessageBody(object):
    #--------------Constructor--------------
    def __init__(self,requestHeader,requestBody,replyHeader,replyBody):
        self.__messageBody = message_pb2.MessageBody()
        self.__messageBody.requestHeader = requestHeader
        self.__messageBody.requestBody = requestBody
        self.__messageBody.replyHeader = replyHeader
        self.__messageBody.replyBody = replyBody

    #---------------------------------------

    #----------Getters and Setters----------
    def getRequestHeader(self):
        return self.__messageBody.requestHeader

    def getRequestBody(self):
        return self.__messageBody.requestBody

    def getReplyHeader(self):
        return self.__messageBody.replyHeader

    def getReplyBody(self):
        return self.__messageBody.replyBody

    def setRequestHeader(self,requestHeader):
        self.__messageBody.requestHeader = requestHeader

    def setRequestBody(self,requestBody):
        self.__messageBody.requestBody = requestBody

    def setReplyHeader(self,replyHeader):
        self.__messageBody.replyHeader = replyHeader

    def setReplyBody(self,replyBody):
        self.__messageBody.replyBody = replyBody

    #---------------------------------------