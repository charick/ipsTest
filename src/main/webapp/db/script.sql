# Host: localhost    Database: test1
# ------------------------------------------------------
# Server version 5.5.15

DROP DATABASE IF EXISTS `test`;
CREATE DATABASE `test` /*!40100 DEFAULT CHARACTER SET gbk */;
USE `test`;

#
# Source for table admininfo
#

DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `Aid` int(11) NOT NULL,
  `Aname` varchar(50) NOT NULL,
  `Apwd` varchar(20) NOT NULL,
  `Alevel` varchar(10) DEFAULT '普通',
  PRIMARY KEY (`Aid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table admininfo
#
LOCK TABLES `admininfo` WRITE;

INSERT INTO `admininfo` VALUES (10001,'wyf','123456','����');
INSERT INTO `admininfo` VALUES (10002,'zrk','123456','��ͨ');
UNLOCK TABLES;

#
# Source for table goodsinfo
#

DROP TABLE IF EXISTS `goodsinfo`;
CREATE TABLE `goodsinfo` (
  `Gid` int(11) NOT NULL,
  `Gname` varchar(100) NOT NULL,
  `Gprice` double NOT NULL,
  `Gclass` varchar(50) DEFAULT '�ӻ�',
  `Gamount` int(11) NOT NULL,
  `Gdate` datetime DEFAULT NULL,
  `Gimgurl` varchar(100) DEFAULT 'img/default.jpg',
  `Glook` int(11) DEFAULT '0',
  `Gintro` text,
  `Gbrief` text,
  PRIMARY KEY (`Gid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table goodsinfo
#
LOCK TABLES `goodsinfo` WRITE;

INSERT INTO `goodsinfo` VALUES (807200001,'Fuwa\'s Olympic Stories',367,'DVD',100,'2008-05-01','img/DVD/807200001.jpg',0,'����:��ΰ��|����:100��|��Ƭ��:10|����:DVD','Ƭ�ӽ����Ĺ��·�����2008���29����˻ῪĻǰϦ�����ڽ����᳡���񳲡��ľ���¥���ס��һ�����֮�ҡ����Ӵ��ѵİְ���������8�����յ���һ�죬�͸���һ�װ��˼�������ޡ���Ϊ�����һ�쿪ʼ�����ޡ��ʹ���ԭ���ġ����ᡱ���֮�䷢���˺ܶ���Ȥ�Ĺ��¡�ͨ����Щ���£�չ���˰���������Ŀ����Դ�뷢չ��������ƶ��������Լ����˾�̾�İ���ʷ�ϵľ�����¡�');
INSERT INTO `goodsinfo` VALUES (807200002,'��ɽ�����ǹ�(DVD)',30,'DVD',100,'2008-07-15','img/DVD/807200002.jpg',0,'����:������|���ݣ����꿥,����|Ƭ����127����|��Ƭ��1|����:DVD','�������ݵ�����Ա���ں���ãã����ɽ������һ�����ţ�����Ҫ��Ψһ�Ķ��ӽ������ŵĹ�������Զ��ӵ�һ�γ�������Աǧ����������ʵ�ڷ��Ĳ��£����Ǵ��ų��������ҹ����Ŷ�����һ������֮�á�ͽ����׳����ɽ�֡�������Ұ�䣬��һ�Ը���չ��ǰ��δ�е���ʶ���˽⣬������ʢ�Ķ��������˽���ʮ�����������ʲ�������������塣������ԱҲ���20���������������յȴ�����κͶ��ӳ�����˵Ľ�����������ɽ��ˮ���ǹ�������һ��������Ļ���һ�������Եĸж���');
INSERT INTO `goodsinfo` VALUES (807200003,'����֮��(��װDVD)',14,'DVD',50,'2008-06-15','img/DVD/807200003.jpg',0,'���ݣ��޲�����ɷ�|���ݣ�����,������,�����,����|Ƭ����94����|��Ƭ��1|���ʣ�DVD','һ�����գ����ʮ������к����Ž�̤��������ʿ�����˽ֵ�һ�ҵ���Ѱ�Ҿ����ղؼ�ֵ���й��Ƭ�����������ڴ����Լ��Ҹ��������ʱ�����鷳����Ϊ��ɭ������һȺ��춢�ϣ����ҳ��ܵ����ǵ��۸�����ɭ��ͨ������Ϸ�����ڹ���ƬҲ��������䣬������ϣ���Լ�Ҳ�ܳ�Ϊһ�����֣�Ȼ���̵��ϰ��ϻ�ȴ��Ϊ����ɭ��������ϣ����֪��ʲô�ǹ���');
INSERT INTO `goodsinfo` VALUES (807200004,'����',30,'DVD',20,'2008-03-21','img/DVD/807200004.jpg',0,'���ݣ����ǳ�|���ݣ����ǳۣ���ʥ������С��Ԫ����Ԫ��|Ƭ����95����|��Ƭ��1|���ʣ�DVD','���·�����20����40�����й����ǳ�����һ��һ���޳ɡ�С͵С���ĹŻ��У���־���뵱ʱ��������ֶβ��̵ĺڰ��ͷ���������ͼ��һ���С������կ���ĵط��Ծ�����թ��ȴ��֪�����Ǹ����?��������������˸�ͷ�����������ĳ�ͻ������ؽ�����ͷ�Ϸ���Եؾ������У�������֮��Ķ�����ʽչ�����ӡ������կ������Ϊ����ս��չ�������������ּ�Ľ��棬���н����ط����˴�ǰ��˼���־�򣬿�ʼ���򹦷�����С�');
INSERT INTO `goodsinfo` VALUES (807200005,'��״Ԫ�����',7,'DVD',15,'2008-07-20','img/DVD/807200005.jpg',0,'���ݣ����ǳۣ����ϴ����|Ƭ����101����|��Ƭ��1|���ʣ�DVD','�ղ���������ڴ󽫾�ۡ���书��ǿ�����Ը��š�����˪�������״Ԫ�����򿼹���ף�����������������֡�������������ֱ����֮��һʱ����ֻ��˯������Ȼһ�죬��ؤ�ﴴʼ�˺��߹��������е��ѡ�ѧ����˯���޺�ȭ�������˰���֮λ���쵼ؤ���������Ȼ��ϣ�������ʷ��');
INSERT INTO `goodsinfo` VALUES (807200006,'�����������¸���Ӣ��.1',47.9,'ͼ��',10,'2008-04-10','img/book/807200006.jpg',0,'���ߣ���Ӣ������ɽ��Alexander,L.G.��������ݷ ��������|�����磺�����ѧ���о�������|����ʱ�䣺 2007-7-1','�����ǡ��¸���Ӣ��״γ���������һ���Ƴ����°汾�����׾���̲�һ�����������ṩһ������ġ�����ʵ������Ӣ��ѧϰ��ϵ��ʹѧ���п�����Ӣ���4�����һ��⡢����Ķ���д��һ��������޶ȵط����Լ���Ǳ�ܡ�');
INSERT INTO `goodsinfo` VALUES (807200007,'Ц���ҵ�Ӣ����',29.8,'ͼ��',12,'2008-07-15','img/book/807200007.jpg',0,'���ߣ����ӣ��ɿ� ����|�����磺�й�㲥���ӳ�����|����ʱ�䣺2007-10-1','����һ����ͼ����Ĭ��������һ��ļ���ѧ��Ӣ���顣����ϵͳ�����������164����������ʽӢ������زľ���Դ�����ڱ�д����У���������辶�������ɻ��õĹ��ºͳ��ôʻ������ں����У���������Ĭ��ͼƬ�����˹�Ŀ���������������Ӣ��ˮƽ�������ÿƪ���¾��������ķ��룬�ʺϸ���ˮƽ�Ķ���ѧϰʹ�á�');
INSERT INTO `goodsinfo` VALUES (807200008,'���Ӣ���龰����100����',38,'ͼ��',20,'2008-06-30','img/book/807200008.jpg',0,'���ߣ��������޿��أ������� ��|�����磺���ĳ�����|����ʱ�䣺 2007-6-1','����Խ���ˡ�������Ĳ�Σ����뵽�������ϸ΢֮������ͬ���͵�����ȣ�ӵ�и�㷺�Ļ��⡢����ı���Ũ��Ȥζ������Carol Rueckert�������Ӣ���ѧר�ң�������Ӣ����������ꡣ����100��������200ƪ�Ի�ϸ��չ���˵���Ӣ���ķ������飬�Լ�Ӣ������ͨ���յĹ�ͨ��ʽ�����齫������ͻ�ƿ���ƿ����ʵ�ֶ໰�⡢���ε�Ӣ�ｻ����');
INSERT INTO `goodsinfo` VALUES (807200009,'���и������ۺϽ̳�',148,'ͼ��',15,'2008-06-30','img/book/807200009.jpg',0,'���ߣ�������������˹��Phillips,D.����|�����磺����ͼ����湫˾|����ʱ�䣺2006-1-1','������ȫ�������и����Ա�׼��д����һ���ۺ��Ե����Լ�����̡߽̳����к��������и����Ը�������Ե��������������ܽ��⣬���ṩ������ģ����Ŀ�������Բ⡣����Ӣ�İ��ڹ��������ʢ�����¶����������󣬶�������˶����з����������й���ߵ�ѧϰ�ص�������ǿ������и�����ѡȨ���ο��顣');
UNLOCK TABLES;

#
# Source for table ordergoods
#

DROP TABLE IF EXISTS `ordergoods`;
CREATE TABLE `ordergoods` (
  `OGid` int(11) NOT NULL,
  `Oid` int(11) NOT NULL,
  `Uid` int(11) NOT NULL,
  `Gid` int(11) NOT NULL,
  `OGamount` int(11) NOT NULL,
  `OGtotalprice` double NOT NULL,
  PRIMARY KEY (`OGid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table ordergoods
#
LOCK TABLES `ordergoods` WRITE;

UNLOCK TABLES;

#
# Source for table orderinfo
#

DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `Oid` int(11) NOT NULL,
  `Odate` datetime NOT NULL,
  `Aid` int(11) DEFAULT NULL,
  `Ostate` varchar(20) DEFAULT NULL,
  `Orecname` varchar(50) NOT NULL,
  `Orecadr` varchar(200) NOT NULL,
  `Orectel` varchar(20) DEFAULT NULL,
  `Uid` int(11) DEFAULT NULL,
  `Ototalprice` double DEFAULT NULL,
  PRIMARY KEY (`Oid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table orderinfo
#
LOCK TABLES `orderinfo` WRITE;

UNLOCK TABLES;

#
# Source for table userinfo
#

DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `Uid` int(11) NOT NULL,
  `Uname` varchar(50) NOT NULL,
  `Upwd` varchar(20) NOT NULL,
  `Uemail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Uid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Dumping data for table userinfo
#
LOCK TABLES `userinfo` WRITE;

INSERT INTO `userinfo` VALUES (10001,'zrk','860607','www.zrk@163.com');
INSERT INTO `userinfo` VALUES (10002,'wyy','871216','www.wyy@163.com');
UNLOCK TABLES;

