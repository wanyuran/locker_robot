### Smart Robot Tasking

#### 场景分析
一个Smart Robot
优先从可用容量最多的空间进行存包
如果其中某几个柜子的可用容量相同，则按顺序存储
确保之前功能work

#### save bag
Given 一个Smart Robot，一个包，一个可用容量为2的locker，一个可用容量为1的locker
When Smart Robot存包
Then 包存进第一个locker并返回一张票

Given 一个Smart Robot，一个包，一个可用容量为1的locker，一个可用容量为2的locker
When Smart Robot存包
Then 包存进第二个locker并返回一张票

Given 一个Smart Robot，一个包，一个可用容量为1的locker，一个可用容量为1的locker
When Smart Robot存包
Then 包存进第一个locker并返回一张票

Given 一个Smart Robot，一个包，一个可用容量为0的locker，一个可用容量为0的locker
When Smart Robot存包
Then Smart Robot提示所有柜子已满

Given 一个Smart Robot，没有包，一个可用容量为1的locker，一个可用容量为0的locker
When Smart Robot存包
Then 返回第一个locker的一张票


#### get bag
Given 一个Smart Robot，一张有效票，一个可用容量为0的locker，一个可用容量为0的locker
When Smart Robot取包
Then 返回包

Given 一个Smart Robot，一张无效票，一个可用容量为0的locker，一个可用容量为0的locker
When Smart Robot取包
Then 提示票据无效

Given 一个Smart Robot，一张有效票，一个可用容量为0的locker，一个可用容量为0的locker
When Smart Robot取包
Then 没有包

