delimiter $
DROP function  IF EXISTS getDeviceChildren;
CREATE function  getDeviceChildren(rootId BIGINT) RETURNS varchar(1000)
  BEGIN
    DECLARE sTemp VARCHAR(1000);
    DECLARE sTempChd VARCHAR(1000);
    SET sTemp = '';
    SET sTempChd =cast(rootId as CHAR);
    WHILE sTempChd is not null DO
      SET sTemp = concat(sTemp,',',sTempChd);
      SELECT group_concat(id) INTO sTempChd FROM device where FIND_IN_SET(parent_id,sTempChd)>0;
    END WHILE;
    RETURN substring(sTemp,2);
  END
$

##使用示例:
select * from device where FIND_IN_SET(id, getDeviceChildren(3037));