using UnityEngine;

public class Push : Interaction
{
    public float force = 5;

    Rigidbody rb;
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        rb = GetComponent<Rigidbody>();
    }

    override protected void Activate()
    {
        Vector3 direction = transform.position - Camera.main.transform.position;
        rb.AddForce(force * direction, ForceMode.Impulse);
    }
}
