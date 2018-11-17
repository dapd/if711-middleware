import message_pb2

class OperationReturn(object):
    #--------------Constructor--------------
    def __init__(self,msg,code):
        self.__operationReturn = message_pb2.OperationReturn()
        self.__operationReturn.msg = msg
        self.__operationReturn.code = code

    #---------------------------------------

    #----------Getters and Setters----------
    def getMsg(self):
        return self.__operationReturn.msg

    def getCode(self):
        return self.__operationReturn.code

    def setMsg(self,msg):
        self.__operationReturn.msg = msg

    def setCode(self,code):
        self.__operationReturn.code = code

    #---------------------------------------