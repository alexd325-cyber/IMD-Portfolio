using UnityEngine;

public class Facer : MonoBehaviour
{
    Transform cam;

    void Start()
    {
        cam = Camera.main.transform;
    }

    void Update()
    {
        transform.LookAt(transform.position + Vector3.up, cam.position - transform.position);
    }
}
