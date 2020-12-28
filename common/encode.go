package common

import (
	"github.com/arsiac/psychology/log"
	"golang.org/x/crypto/bcrypt"
	"math/rand"
)

const maxRandomValue = bcrypt.MaxCost - bcrypt.MinCost

func GetRandomCost() int {
	value := rand.Intn(maxRandomValue)
	return value + bcrypt.MinCost
}

func EncryptPassword(password string) string  {
	//cost := GetRandomCost()
	cost := bcrypt.DefaultCost
	encodePassword, err := bcrypt.GenerateFromPassword([]byte(password), cost)
	if err != nil {
		log.Errorln("加密失败", err)
	}
	log.WithFields(log.Fields{
		"password": password,
		"cost": cost,
		"encode": string(encodePassword),
	}).Debugln("加密结果")
	return string(encodePassword)
}

func ComparePassword(password, encode string) bool {
	err := bcrypt.CompareHashAndPassword([]byte(encode), []byte(password))
	if err != nil {
		log.Errorln(err)
		return false
	}
	return true
}
