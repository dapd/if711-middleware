class Transaction(object):
    #--------------Constructor--------------
    def __init__(self,srcAccId,value,date,dstAccId):
        self.__transactionSrcAccId = srcAccId
        self.__transactionValue = value
        self.__transactionDate = date
        self.__transactionDstAccId = dstAccId
        self.__transactionStatus = True

    #---------------------------------------

    #----------Getters and Setters----------
    def getTransactionSrcAccId(self):
        return self.__transactionSrcAccId
    
    def getTransactionValue(self):
        return self.__transactionValue

    def getTransactionDate(self):
        return self.__transactionDate

    def getTransactionDstAccId(self):
        return self.__transactionDstAccId

    def getTransactionStatus(self):
        return self.__transactionStatus

    def setTransactionStatus(self,status):
        self.__transactionStatus = status
    
    #--------------------------------------
