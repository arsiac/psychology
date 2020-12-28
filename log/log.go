package log

import (
	"github.com/sirupsen/logrus"
	"os"
)

var logger = logrus.New()

func init() {
	logger.SetOutput(os.Stdout)
	logger.SetLevel(logrus.DebugLevel)
	logger.SetReportCaller(false)
	logger.SetFormatter(&logrus.TextFormatter{
		TimestampFormat: "2006-01-02 15:04:05",
		DisableTimestamp: false,
		FullTimestamp: true,
	})
}

func GetLogger() *logrus.Logger {
	return logger
}

type Fields logrus.Fields

// 日志方法
func WithField(key string, value interface{}) *logrus.Entry {
	return logger.WithField(key, value)
}

func WithFields(fields Fields) *logrus.Entry {
	return logger.WithFields(logrus.Fields(fields))
}

func Debugln(args ...interface{}) {
	logger.Debugln(args)
}

func Debugf(format string, args ...interface{}) {
	logger.Debugf(format, args)
}

func Infoln(args ...interface{}) {
	logger.Infoln(args)
}

func Infof(format string, args ...interface{}) {
	logger.Infof(format, args)
}

func Warnln(args ...interface{}) {
	logger.Warningln(args)
}

func Warnf(format string, args ...interface{}) {
	logger.Warningf(format, args)
}

func Errorln(args ...interface{}) {
	logger.Errorln(args)
}

func Errorf(format string, args ...interface{}) {
	logger.Errorf(format, args)
}
