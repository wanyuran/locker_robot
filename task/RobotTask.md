### save bag

Given  一个容量为1的locker1，一个容量为1的locker2，一个管理locker的机器人，一个包
When  机器人存包
Then 机器人把包存进locker1，并返回一张票



Given  一个容量为0的locker1 ，一个容量为1的locker2，一个管理locker的机器人，一个包
When  机器人存包
Then  机器人把包存进locker2，并返回一张票



Given  一个容量为0的locker1，一个容量为0的locker2，一个管理locker的机器人，一个包
When  机器人存包
Then 机器人提示用户柜子满了



Given  一个容量为0的locker1 ，一个容量为1的locker2，一个管理locker的机器人，没有包
When  机器人存包
Then  机器人提示用户需要给机器人包



### get bag

Given  一张有效票，一个容量为0的locker1，一个容量为0的locker2，一个管理locker的机器人
When  机器人取包
Then   机器人返回寄存的包



Given  一张错误票，一个容量为0的locker1，一个容量为0的locker2，一个管理locker的机器人
When  机器人取包
Then   机器人提示用户无效票



Given  一张已使用的票，一个容量为0的locker1，一个容量为0的locker2，一个管理locker的机器人
When  机器人取包
Then   机器人提示用户无效票


