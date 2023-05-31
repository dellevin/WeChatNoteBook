# WeChatNoteBook
因为日常生活终重度使用微信，开发本工具的目的旨在用微信公众号记录生活随笔，并加之前端展示，实现多端记录以及随时随地的记录生活趣事。
# 开发进度
- [x] 创建项目
- [x] 发送消息创建用户
- [ ] 发送消息保存消息
- [ ] 分标签保存消息
- [ ] redis支持


# 微信公众号笔记本
微信公众号：几许卿言

## 技术栈

前端：暂定，先写后端做调试（2023年5月29日）

后端：java

数据库：redis+mysql



## 数据库表
数据库结构有问题，正在想思考重建

## 思路

### 如何判断文本消息是否为需要保存的笔记？

先判断是哪个用户，然后再通过标签判断插入笔记，插入成功则通过微信公众号回复消息“保存成功”

初步构思是利用标签进行操作，初步构思是利用 `# + ：`进行分割

**比如**

单标签：`#随笔：`

多标签：`#文摘#笔记：`

### 前端登录方式？

可以采用用户的openid作为用户名，随机生成的密码作为登录密码

返还消息的格式是这样的

```txt
笔记已记录,在线查看请在浏览器中访问。
网址：www.xxxxx.com
账户：用户的openid
密码：随机生成的密码
```

