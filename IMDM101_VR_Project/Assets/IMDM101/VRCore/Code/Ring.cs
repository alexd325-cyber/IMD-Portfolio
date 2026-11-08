using UnityEngine;

public class Ring : Interaction
{
    public AudioClip sound;
    AudioSource audioSource;
    void Start()
    {
        audioSource = gameObject.AddComponent<AudioSource>();
    }

    override protected void Activate()
    {
        audioSource.PlayOneShot(sound);
    }
}
