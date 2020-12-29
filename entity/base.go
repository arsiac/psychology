package entity

import (
	"fmt"
	"time"
)

type Page struct {
	Total int `json:"total"`
	Size  int `json:"size"`
	Index int `json:"index"`
	List interface{} `json:"list"`
}

func (p *Page)String() string {
	return fmt.Sprintf("Page{ total: %v, size: %v, index: %v, list: %v}", p.Total, p.Size, p.Index, p.List)
}

type BaseModel struct {
	ID        int64      `gorm:"primary_key"`
	CreatedAt time.Time
	UpdatedAt time.Time
	DeletedAt *time.Time `sql:"index"`
}

type BaseModelVo struct {
	ID        string      `json:"id"`
	CreatedAt string  `json:"createdAt"`
	UpdatedAt string  `json:"updatedAt"`
}

func NewPage(total, size, index int) *Page {
	page := new(Page)
	page.Total = total
	page.Size = size
	page.Index = index
	return page
}

func GetDefaultPage() *Page {
	return NewPage(0, 10, 1)
}
