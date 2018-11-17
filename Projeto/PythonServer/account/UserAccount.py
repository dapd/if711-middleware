class UserAccount(object):
    #--------------Constructor--------------
    def __init__(self,userId,name,cpf,birth):
        self.__userId = userId
        self.__userName = name
        self.__userCPF = cpf
        self.__userBirth = birth

    #---------------------------------------

    #----------Getters and Setters----------
    def getUserId(self):
        return self.__userId

    def getUserName(self):
        return self.__userName

    def getUserCPF(self):
        return self.__userCPF

    def getUserBirth(self):
        return self.__userBirth

    def setUserName(self,userName):
        self.__userName = userName

    def setUserCPF(self,userCPF):
        self.__userCPF = userCPF

    def setUserBirth(self,userBirth):
        self.__userBirth = userBirth

    #---------------------------------------
