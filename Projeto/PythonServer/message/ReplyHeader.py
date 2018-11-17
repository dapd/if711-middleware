import message_pb2

class ReplyHeader(object):
    #--------------Constructor--------------
    def __init__(self,serviceContext,requestId,replyStatus):
        self.__replyHeader = message_pb2.ReplyHeader()
        self.__replyHeader.serviceContext = serviceContext
        self.__replyHeader.requestId = requestId
        self.__replyHeader.replyStatus = replyStatus

    #---------------------------------------

    #----------Getters and Setters----------
    def getServiceContext(self):
        return self.__replyHeader.serviceContext

    def getRequestId(self):
        return self.__replyHeader.requestId

    def getReplyStatus(self):
        return self.__replyHeader.replyStatus

    def setServiceContext(self,serviceContext):
        self.__replyHeader.serviceContext = serviceContext

    def setRequestId(self,requestId):
        self.__replyHeader.requestId = requestId

    def setReplyStatus(self,replyStatus):
        self.__replyHeader.replyStatus = replyStatus

    #---------------------------------------