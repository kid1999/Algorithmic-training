


def flipAndInvertImage( A):
    res = []
    for ll in A:
        temp = []
        for d in ll[::-1]:
            if d == 0: temp.append(1)
            else: temp.append(0)
        res.append(temp)
    return res

print(flipAndInvertImage([[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]))