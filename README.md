# WeChatNoteBook
因为日常生活终重度使用微信，开发本工具的目的旨在用微信公众号记录生活随笔，并加之前端展示，实现多端记录以及随时随地的记录生活趣事。
# 开发进度
- [x] 创建项目
- [x] 发送消息创建用户
- [x] 再次发送消息返还用户数据
- [x] 发送消息保存消息
- [ ] 前端加入标签支持
- [ ] redis支持
- [ ] 未完待续......

# 微信公众号笔记本

微信公众号：测试号

## 技术栈
前端：暂定，先写后端做调试（2023年5月29日）

后端：java

数据库：mysql（暂时是mysql）

## 数据库表
数据库结构有问题，正在想思考重建

## 思路

### 如何判断文本消息是否为需要保存的笔记？

先判断是哪个用户，然后再通过标签判断插入笔记，插入成功则通过微信公众号回复消息“保存成功”

初步构思是利用标签进行操作，初步构思是利用 `<笔记>`作为微信发送笔记的记录方式


**比如**

```
<笔记>
我在想为什么人这么平凡的原因是什么？因为没有真正努力过。
他所作的一切都是为了融入社会，是社会推着他的前进。
```
通过识别前四位来判断是否为需要保存的笔记。


### 前端登录方式？

可以采用用户的openid作为用户名，随机生成的密码作为登录密码
同时你必须创建用户才可以发送笔记，若没有创建用户，是无法发送笔记的


返还消息的格式是这样的

```txt
笔记已记录,在线查看请在浏览器中访问。
网址：www.xxxxx.com
账户：用户的openid
密码：随机生成的密码
```

