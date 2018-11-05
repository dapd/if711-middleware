class Account(object):
    #--------------Constructor--------------
    def __init__(self,accId,balance,number,accType,userAccId):
        self.__accountId = accId
        self.__accountBalance = balance
        self.__accountNumber = number
        self.__accountType = accType
        self.__userAccountId = userAccId
        self.__accountStatus = False
    
    #---------------------------------------

    #----------Getters and Setters----------
    def getAccountId(self):
        return self.__accountId

    def getAccountBalance(self):
        return self.__accountBalance

    def getAccountNumber(self):
        return self.__accountNumber

    def getAccountType(self):
        return self.__accountType

    def getUserAccountId(self):
        return self.__userAccountId

    def getAccountStatus(self):
        return self.__accountStatus

    def setAccountBalance(self,balance):
        self.__accountBalance = balance

    def setAccountNumber(self,number):
        self.__accountNumber = number

    def setAccountType(self,accType):
        self.__accountType = accType

    def setAccountStatus(self,status):
        self.__accountStatus = status

    #---------------------------------------