def min(a, b):
    if a < b:
        return a
    else:
        return b

N = int(input())

dp = []
for i in range(N + 1):
    dp.append(0)

i = 2
while i <= N:
    dp[i] = dp[i - 1] + 1
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[int(i/2)] + 1)
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[int(i/3)] + 1)
    i += 1
    
print(dp[N])
