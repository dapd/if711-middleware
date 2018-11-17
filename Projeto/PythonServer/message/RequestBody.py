import message_pb2

class RequestBody(object):
    #--------------Constructor--------------
    def __init__(self,parameters):
        self.__requestBody = message_pb2.RequestBody()
        self.__requestBody.parameters = parameters

    #---------------------------------------

    #----------Getters and Setters----------
    def getParameters(self):
        return self.__requestBody.parameters

    def setParameters(self,parameters):
        self.__requestBody.parameters = parameters

    #---------------------------------------