class num(object):
    def __init__(self,nums):
        self.x = nums

    #在print中输出 class 的String
    def __str__(self):
        return str(self.x)

    def __len__(self):
        return len(self.x) 
    
    def __repr__(self):  #优先考虑 repr 函数的string
        return str(self.x)

    def __getitem__(self,item): #可迭代对象
        return self.x[item]

one = num([1,2,3])
print(one)
for n in one:
    print(n)
