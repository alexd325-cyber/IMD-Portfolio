using UnityEngine;
#if UNITY_EDITOR
using UnityEditor;
#endif

public class SceneNote : MonoBehaviour
{
    [TextArea] public string note;
}

#if UNITY_EDITOR
[CustomEditor(typeof(SceneNote))]
public class SceneNoteEditor : Editor
{
    void OnSceneGUI()
    {
        SceneNote n = (SceneNote)target;
        Handles.Label(n.transform.position, n.note);
    }
}
#endif