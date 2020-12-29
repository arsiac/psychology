package constant

import (
	"github.com/arsiac/psychology/common"
	"github.com/arsiac/psychology/common/log"
	"gopkg.in/yaml.v2"
	"strconv"
)

// App name
const (
	App = "psychology"
	TimeFormat = "2006-01-02 15:04:05"
)

var (
	// "/etc/psychology/config.yaml"
	ConfigFile = "/home/data/workspace/go/src/github.com/arsiac/psychology/resource/config.yaml"
	MysqlInfo = common.GetDefaultMysqlSettings()
	MysqlUrl = common.GenerateMysqlUrl(MysqlInfo)
	LogLevel = "info"
	WorkId = int64(0)
	Snowflake *common.Worker
	Port = 8080

	// page
	PageSize = 10
)

/*
 * app 配置
 */
func configApp(appMap map[interface{}]interface{})  {
	port := appMap["port"]
	if port != nil {
		Port = port.(int)
		log.Debugln("app.port", Port)
	} else {
		log.Warnln("未配置 app.port，将使用默认 port", Port)
	}
	workId := appMap["workId"]
	if workId != nil {
		WorkId = int64(workId.(int))
		log.Debugln("app.workId", WorkId)
	} else {
		log.Warnln("未配置 app.workId 将使用默认 workId", WorkId)
	}
	Snowflake, _ = common.NewWorker(WorkId)

	pageSize := appMap["pageSize"]
	if pageSize != nil {
		PageSize = pageSize.(int)
	} else {
		log.Warnln("未配置 app.pageSize 将使用默认 pageSize", PageSize)
	}
}

/*
 * mysql 配置
 */
func configMysql(mysqlMap map[interface{}]interface{}) {
	address := mysqlMap["address"]
	port := mysqlMap["port"]
	database := mysqlMap["database"]
	username := mysqlMap["username"]
	password := mysqlMap["password"]
	option := mysqlMap["option"]

	if address != nil && port != nil && database != nil && username != nil && password != nil && option != nil {
		MysqlInfo.Address = address.(string)
		MysqlInfo.Port = port.(int)
		MysqlInfo.Database = database.(string)
		MysqlInfo.Username = username.(string)
		MysqlInfo.Option = option.(string)
		strPassword, ok := password.(string)
		if ok {
			MysqlInfo.Password = strPassword
		} else {
			MysqlInfo.Password = strconv.Itoa(password.(int))
		}
		MysqlUrl = common.GenerateMysqlUrl(MysqlInfo)
	} else {
		log.Warnln("配置文件 mysql 配置不正确, 将会使用默认配置", mysqlMap)
	}
}

func Init() {
	fileContent, err := common.ReadFile(ConfigFile)
	if err != nil {
		log.Errorln("读取配置文件失败,将使用默认配置", err)
		return
	}
	configMap := make(map[string]interface{})
	err = yaml.Unmarshal(fileContent, &configMap)
	if err != nil {
		log.Errorln("配置文件解析失败", err)
		return
	}
	//log.Infoln("配置信息", configMap)

	// app 配置
	if appMapInterface := configMap["app"]; appMapInterface != nil {
		configApp(appMapInterface.(map[interface{}]interface{}))
	}
	// mysql 配置
	if mysqlMapInterface := configMap["mysql"]; mysqlMapInterface != nil {
		configMysql(mysqlMapInterface.(map[interface{}]interface{}))
	}
}


