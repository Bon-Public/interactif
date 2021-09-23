extends Node2D

var emotion_node:Sprite

func _ready():
	pass
	
func _process(delta):
	pass

func switch_emotion(emotion):
	if get_node(emotion):
		emotion_node.visible = false
		emotion_node = get_node(emotion)
		emotion_node.visible = true
