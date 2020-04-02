# Tasking


### 存包
Given 一个容量为1的柜子，一个包

When 存包

Then 返回一张票


Given 一个容量为0的柜子，一个包

When 存包

Then 提示用户柜子满了



Given 一个容量为1的柜子，两个包

When 连续存两次

Then 提示用户柜子满了



Given 一个容量为0的柜子，一张票，一个包

When 先取包，再存包

Then 返回一张票



### 取包
Given 一个容量为0柜子，一张有效的票

When 取包

Then 返回包



Given 一个容量为0柜子，一张无效的票

When 取包

Then 提示用户小票无效



Given 一个容量为0柜子，一张已取过的票

When 取包

Then 提示用户小票无效








