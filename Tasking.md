# Tasking

Given 一个柜子，一个包

When 存包

Then 返回一张票，容量-1



Given 一个柜子， 没有包

When 存包

Then 返回一张票，容量-1



Given 一个容量为0的柜子，一个包

When 存包

Then 提示用户柜子满了，容量不变



Given 一个柜子，一张有效的票

When 取包

Then 返回包，容量+1



Given 一个柜子，一张有效的票

When 取包

Then 没有包，容量+1



Given 一个柜子，一张无效的票

When 取包

Then 提示用户小票无效，容量不变









