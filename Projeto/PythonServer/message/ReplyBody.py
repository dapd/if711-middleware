import message_pb2

class ReplyBody(object):
    #--------------Constructor--------------
    def __init__(self,opReturn):
        self.__replyBody = message_pb2.ReplyBody()
        self.__replyBody.opReturn = opReturn

    #---------------------------------------

    #----------Getters and Setters----------
    def getOpReturn(self):
        return self.__replyBody.opReturn

    def setOpReturn(self,opReturn):
        self.__replyBody.opReturn = opReturn

    #---------------------------------------