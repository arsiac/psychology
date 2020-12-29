package log

type Level int

var (
	// 日志级别 map
	LevelMap = map[string]Level{
		ERROR.String():  ERROR,
		WARN.String():   WARN,
		INFO.String():   INFO,
		DEBUG.String():  DEBUG,
		SILENT.String(): SILENT,
	}
)

// 日志级别
const (
	DEBUG Level = iota
	INFO
	WARN
	ERROR
	SILENT
)

// 获取日志级别对应的 string
func (level Level) String() string {
	switch level {
	case DEBUG:
		return "debug"
	case ERROR:
		return "error"
	case INFO:
		return "info"
	case WARN:
		return "warn"
	case SILENT:
		return "silent"
	default:
		return "unknown"
	}
}
