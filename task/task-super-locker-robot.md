### Super Robot Tasking

#### 场景分析
一个Super Robot
优先从空置率最高的柜子进行存包
如果其中某几个柜子的空置率相同，则按顺序存储
确保之前功能work

### save bag
Given 一个Super Robot，一个包，一个空置率为50%的locker1，一个空置率为100%的locker2
When Super Robot存包
Then 返回一张locker2的票

Given 一个Super Robot，一个包，一个空置率为100%的柜子1，一个空置率为50%的柜子2
When Super Robot存包
Then 返回一张柜子1的票

Given 一个Super Robot，一个包，一个空置率为50%的柜子1，一个空置率为50%的柜子2
When Super Robot存包
Then 返回一张柜子1的票

Given 一个Super Robot，一个包，一个空置率为0%的柜子1，一个空置率为0%的柜子2
When Super Robot存包
Then 提示用户柜子已满

### get bag
Given 一个Super Robot，一张有效票，一个空置率为0%的locker1，一个空置率为0%的locker2
When Super Robot取包
Then 返回包

Given 一个Super Robot，一张无效票，一个空置率为0%的locker1，一个空置率为0%的locker2
When Super Robot取包
Then 提示用户票据无效