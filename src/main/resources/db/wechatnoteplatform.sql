/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.40 : Database - wechatnoteplatform
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wechatnoteplatform` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wechatnoteplatform`;

/*Table structure for table `tag_and_note` */

DROP TABLE IF EXISTS `tag_and_note`;

CREATE TABLE `tag_and_note` (
  `tagID` int(255) DEFAULT NULL COMMENT '标签id',
  `noteID` int(255) DEFAULT NULL COMMENT '笔记id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tag_and_note` */

/*Table structure for table `user_and_note` */

DROP TABLE IF EXISTS `user_and_note`;

CREATE TABLE `user_and_note` (
  `userID` int(255) DEFAULT NULL COMMENT '用户id',
  `noteID` int(255) DEFAULT NULL COMMENT '笔记id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_and_note` */

/*Table structure for table `wechat_note` */

DROP TABLE IF EXISTS `wechat_note`;

CREATE TABLE `wechat_note` (
  `note_id` int(255) DEFAULT NULL COMMENT '笔记id',
  `note_time` datetime DEFAULT NULL COMMENT '笔记保存的时间',
  `note_content` longtext COMMENT '笔记内容'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wechat_note` */

/*Table structure for table `wechat_note_tag` */

DROP TABLE IF EXISTS `wechat_note_tag`;

CREATE TABLE `wechat_note_tag` (
  `tag_id` int(255) DEFAULT NULL COMMENT '笔记标签id',
  `tag_text` varchar(255) DEFAULT NULL COMMENT '笔记标签'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wechat_note_tag` */

/*Table structure for table `wechat_user` */

DROP TABLE IF EXISTS `wechat_user`;

CREATE TABLE `wechat_user` (
  `user_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '微信用户姓名openid',
  `user_password` varchar(255) DEFAULT NULL COMMENT '微信用户密码',
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `wechat_user` */

insert  into `wechat_user`(`user_id`,`user_name`,`user_password`) values 
(1,'admin','admin123'),
(2,'o-ena6Zm3UH_cX6c89H_7qgUONMw','kwYpYp?l~.@J`Oq$');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
