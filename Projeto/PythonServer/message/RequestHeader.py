import message_pb2

class RequestHeader(object):
    #--------------Constructor--------------
    def __init__(self,context,requestId,responseExpected,objectKey,operation):
        self.__requestHeader = message_pb2.RequestHeader()
        self.__requestHeader.context = context
        self.__requestHeader.requestId = requestId
        self.__requestHeader.responseExpected = responseExpected
        self.__requestHeader.objectKey = objectKey
        self.__requestHeader.operation = operation

    #---------------------------------------

    #----------Getters and Setters----------
    def getContext(self):
        return self.__requestHeader.context

    def getRequestId(self):
        return self.__requestHeader.requestId

    def getResponseExpected(self):
        return self.__requestHeader.responseExpected

    def getObjectKey(self):
        return self.__requestHeader.objectKey

    def getOperation(self):
        return self.__requestHeader.operation

    def setContext(self,context):
        self.__requestHeader.context = context

    def setRequestId(self,requestId):
        self.__requestHeader.requestId = requestId

    def setResponseExpected(self,responseExpected):
        self.__requestHeader.responseExpected = responseExpected

    def setObjectKey(self,objectKey):
        self.__requestHeader.objectKey = objectKey

    def setOperation(self,operation):
        self.__requestHeader.operation = operation

    #---------------------------------------