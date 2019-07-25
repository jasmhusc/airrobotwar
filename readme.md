# 外星人大战

## 1.游戏介绍
- 实现飞船发射子弹，子弹攻击前行道路上遇到的外星人。
- 飞船战舰遇到外星人，自身就会收到伤害，外星人被子弹高级后，生命终结死亡。


## 2.游戏元素
- 飞船：引入图片，可以实现键盘控制上，下，左，右移动。
- 外星人：在游戏进行过程中随机出现在屏幕上方，遇到子弹生命受损。
- 子弹：飞船上方会连续出现一系列子弹，子弹不停移动，消失于屏幕外后会消失。
- 背景：背景采用2张以上图片交替出现来实现，并让图片匀速下移，无缝连接实现飞船移动。
- 音效：待定
- 特效：待定

## 3.实时问题
- 以上各种游戏元素如何联系起来呢？
- 分别建立那些类和对象呢？如何实现他们之间的交互？
- 如和增强游戏的可扩展性？
- 如何体现出MVC设计模式，未来可能不再在swing里显示画面了。
- 能添加按钮及其他游戏设置吗？
- 能实现游戏关卡吗？
- ...未完待续